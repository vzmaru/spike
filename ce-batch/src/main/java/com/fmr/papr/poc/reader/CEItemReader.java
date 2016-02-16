package com.fmr.papr.poc.reader;

import com.fmr.papr.poc.dao.EntityDAO;
import com.fmr.papr.poc.domain.Composite;
import com.fmr.papr.poc.domain.Entity;
import org.springframework.batch.item.*;

import java.util.List;

/**
 * Created by vishal on 2/14/16.
 */
public class CEItemReader implements ItemStreamReader<Composite> {
    private ItemStreamReader<Composite> compositeReader;
    private EntityDAO entityDAO;

    @Override
    public Composite read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        Composite composite = compositeReader.read();
        if (composite == null) {
            return null;
        }

        List<Entity> entities = entityDAO.getEntitiesByCompositeId(composite.getCompositeId());
        composite.setEntities(entities);

        return composite;
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        compositeReader.open(executionContext);
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        compositeReader.update(executionContext);
    }

    @Override
    public void close() throws ItemStreamException {
        compositeReader.close();
    }

    public void setCompositeReader(ItemStreamReader<Composite> compositeReader) {
        this.compositeReader = compositeReader;
    }

    public void setEntityDAO(EntityDAO entityDAO) {
        this.entityDAO = entityDAO;
    }

}
