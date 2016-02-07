package com.vm.batch.utils;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by vishal on 2/7/16.
 */
public class BatchUtilsNamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("file-read", new FileItemReaderBeanDefinitionParser());
        registerBeanDefinitionParser("file-write", new FileItemWriterBeanDefinitionParser());
    }

}
