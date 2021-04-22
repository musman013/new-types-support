package com.fastcode.example.restcontrollers.extended;

import com.fastcode.example.application.extended.t1.IT1AppServiceExtended;
import com.fastcode.example.commons.logging.LoggingHelper;
import com.fastcode.example.restcontrollers.core.T1Controller;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/t1/extended")
public class T1ControllerExtended extends T1Controller {

    public T1ControllerExtended(IT1AppServiceExtended t1AppServiceExtended, LoggingHelper helper, Environment env) {
        super(t1AppServiceExtended, helper, env);
    }
    //Add your custom code here

}
