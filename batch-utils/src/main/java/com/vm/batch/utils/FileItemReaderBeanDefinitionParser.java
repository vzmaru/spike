package com.vm.batch.utils;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
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
public class FileItemReaderBeanDefinitionParser extends AbstractBeanDefinitionParser {

    protected AbstractBeanDefinition parseInternal(Element element, ParserContext parserContext) {
        return parseFileReadElement(element);
    }

    private AbstractBeanDefinition parseFileReadElement(Element element) {
        BeanDefinitionBuilder fileReader = BeanDefinitionBuilder.rootBeanDefinition(FlatFileItemReader.class);
        fileReader.addPropertyValue("resource", element.getAttribute("resource"));
        fileReader.addPropertyValue("lineMapper", lineMapperBeanDef(element));

        String scope = element.getAttribute("scope");
        if (StringUtils.hasText(scope)) {
            fileReader.setScope(scope);
        }

        return fileReader.getBeanDefinition();
    }

    private BeanDefinition lineMapperBeanDef(Element element) {
        BeanDefinitionBuilder lineMapper = BeanDefinitionBuilder.rootBeanDefinition(DefaultLineMapper.class);
        lineMapper.addPropertyValue("lineTokenizer", lineTokenizerBeanDef(element));
        lineMapper.addPropertyValue("fieldSetMapper", fieldSetMapperBeanDef(element));
        return lineMapper.getBeanDefinition();
    }

    private BeanDefinition lineTokenizerBeanDef(Element element) {
        BeanDefinitionBuilder lineTokenizer = BeanDefinitionBuilder.rootBeanDefinition(DelimitedLineTokenizer.class);
        lineTokenizer.addPropertyValue("names", element.getAttribute("fieldNames"));

        String delimiter = element.getAttribute("delimiter");
        if (StringUtils.hasText(delimiter)) {
            lineTokenizer.addPropertyValue("delimiter", delimiter);
        }

        return lineTokenizer.getBeanDefinition();
    }

    private BeanDefinition fieldSetMapperBeanDef(Element element) {
        BeanDefinitionBuilder fieldSetMapper = BeanDefinitionBuilder.rootBeanDefinition(BeanWrapperFieldSetMapper.class);
        fieldSetMapper.addPropertyValue("targetType", element.getAttribute("beanType"));
        return fieldSetMapper.getBeanDefinition();
    }

}
