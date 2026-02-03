package com.jokerdb.mm.custom;

import com.jokerdb.mm.constant.DbType;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class JokerDbImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata metadata) {

        Map<String, Object> attrs =
                metadata.getAnnotationAttributes(
                        JokerDbConfig.class.getName());

        JokerConfigHolder.TYPE = (DbType) attrs.get("type");
        JokerConfigHolder.NAME = (String) attrs.get("name");
        JokerConfigHolder.USERNAME = (String) attrs.get("username");
        JokerConfigHolder.PASSWORD = (String) attrs.get("password");

        return new String[]{JokerDbAutoConfiguration.class.getName()};
    }
}
