package com.vm.batch.utils;

import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractBeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * Created by vishal on 2/7/16.
 */
public class FileItemWriterBeanDefinitionParser extends AbstractBeanDefinitionParser {

    protected AbstractBeanDefinition parseInternal(Element element, ParserContext parserContext) {
        return parseFileReadElement(element);
    }

    private AbstractBeanDefinition parseFileReadElement(Element element) {
        BeanDefinitionBuilder fileWriter = BeanDefinitionBuilder.rootBeanDefinition(FlatFileItemWriter.class);
        fileWriter.addPropertyValue("resource", element.getAttribute("resource"));
        fileWriter.addPropertyValue("appendAllowed", "true");
        fileWriter.addPropertyValue("lineAggregator", lineAggregatorBeanDef(element));

        String scope = element.getAttribute("scope");
        if (StringUtils.hasText(scope)) {
            fileWriter.setScope(scope);
        }

        return fileWriter.getBeanDefinition();
    }

    private BeanDefinition lineAggregatorBeanDef(Element element) {
        BeanDefinitionBuilder lineAggregator = BeanDefinitionBuilder.rootBeanDefinition(DelimitedLineAggregator.class);
        lineAggregator.addPropertyValue("fieldExtractor", fieldExtractorBeanDef(element));

        String delimiter = element.getAttribute("delimiter");
        if (StringUtils.hasText(delimiter)) {
            lineAggregator.addPropertyValue("delimiter", delimiter);
        }

        return lineAggregator.getBeanDefinition();
    }

    private BeanDefinition fieldExtractorBeanDef(Element element) {
        BeanDefinitionBuilder fieldExtractor = BeanDefinitionBuilder.rootBeanDefinition(BeanWrapperFieldExtractor.class);
        fieldExtractor.addPropertyValue("names", element.getAttribute("fieldNames"));

        return fieldExtractor.getBeanDefinition();
    }

}
