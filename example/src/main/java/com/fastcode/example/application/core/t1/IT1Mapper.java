package com.fastcode.example.application.core.t1;

import com.fastcode.example.application.core.t1.dto.*;
import com.fastcode.example.domain.core.t1.T1Entity;
import java.time.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IT1Mapper {
    T1Entity createT1InputToT1Entity(CreateT1Input t1Dto);
    CreateT1Output t1EntityToCreateT1Output(T1Entity entity);

    T1Entity updateT1InputToT1Entity(UpdateT1Input t1Dto);

    UpdateT1Output t1EntityToUpdateT1Output(T1Entity entity);

    FindT1ByIdOutput t1EntityToFindT1ByIdOutput(T1Entity entity);
}
