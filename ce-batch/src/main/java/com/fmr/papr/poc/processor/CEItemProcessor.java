package com.fmr.papr.poc.processor;

import com.fmr.papr.poc.domain.Composite;
import com.fmr.papr.poc.domain.Entity;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by vishal on 2/14/16.
 */
public class CEItemProcessor implements ItemProcessor<Composite, Composite> {
    @Override
    public Composite process(Composite item) throws Exception {
        Double total = 0.0;
        Double weightedSum = 0.0;
        for (Entity entity : item.getEntities()) {
            total += entity.getMrktVal();
            weightedSum += entity.getMrktVal() * entity.getPerfVal();
        }

        item.setMrktVal(total);
        item.setPerfVal(weightedSum / total);

        return item;
    }
}
