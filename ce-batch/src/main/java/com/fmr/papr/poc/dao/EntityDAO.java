package com.fmr.papr.poc.dao;

import com.fmr.papr.poc.domain.Entity;

import java.util.List;

/**
 * Created by vishal on 2/13/16.
 */
public interface EntityDAO {
    List<Entity> getEntitiesByCompositeId(String compositeId);
}
