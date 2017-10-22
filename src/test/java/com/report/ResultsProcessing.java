package com.report;

import com.event.BrickseekSearchEvent;
import org.springframework.context.event.EventListener;

public class ResultsProcessing {

    @EventListener
    public void processBrickseekSearchEvent(BrickseekSearchEvent brickseekSearchEvent){
        System.out.println(brickseekSearchEvent.toString());
    }
}
