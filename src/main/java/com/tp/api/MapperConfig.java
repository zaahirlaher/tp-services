package com.tp.api;

import com.tp.api.entities.FormClass;
import com.tp.api.forms.dao.FormClassDao;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    @Bean
    public MapperFacade formClassMapper() {
        mapperFactory.classMap(FormClass.class, FormClassDao.class).byDefault();
        return mapperFactory.getMapperFacade();
    }

}
