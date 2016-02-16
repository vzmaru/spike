package com.fmr.papr.poc.dao.impl;

import com.fmr.papr.poc.dao.EntityDAO;
import com.fmr.papr.poc.domain.Entity;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vishal on 2/13/16.
 */
public class FileEntityDAOImpl implements EntityDAO {
    private LineMapper<Entity> lineMapper;
    private Resource path;

    @Override
    public List<Entity> getEntitiesByCompositeId(String compositeId) {
        List<Entity> entities = new ArrayList<>();
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(path.getFile(), compositeId + ".csv")));
            while ((line = reader.readLine()) != null) {
                entities.add(lineMapper.mapLine(line, 0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entities;
    }

    public void setLineMapper(LineMapper<Entity> lineMapper) {
        this.lineMapper = lineMapper;
    }

    public void setPath(Resource path) {
        this.path = path;
    }
}
