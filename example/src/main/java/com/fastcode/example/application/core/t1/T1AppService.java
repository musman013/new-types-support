package com.fastcode.example.application.core.t1;

import com.fastcode.example.application.core.t1.dto.*;
import com.fastcode.example.commons.logging.LoggingHelper;
import com.fastcode.example.commons.search.*;
import com.fastcode.example.domain.core.t1.IT1Repository;
import com.fastcode.example.domain.core.t1.QT1Entity;
import com.fastcode.example.domain.core.t1.T1Entity;
import com.querydsl.core.BooleanBuilder;
import java.time.*;
import java.util.*;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("t1AppService")
@RequiredArgsConstructor
public class T1AppService implements IT1AppService {

    @Qualifier("t1Repository")
    @NonNull
    protected final IT1Repository _t1Repository;

    @Qualifier("IT1MapperImpl")
    @NonNull
    protected final IT1Mapper mapper;

    @NonNull
    protected final LoggingHelper logHelper;

    @Transactional(propagation = Propagation.REQUIRED)
    public CreateT1Output create(CreateT1Input input) {
        T1Entity t1 = mapper.createT1InputToT1Entity(input);

        T1Entity createdT1 = _t1Repository.save(t1);
        return mapper.t1EntityToCreateT1Output(createdT1);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public UpdateT1Output update(Long t1Id, UpdateT1Input input) {
        T1Entity existing = _t1Repository.findById(t1Id).get();

        T1Entity t1 = mapper.updateT1InputToT1Entity(input);

        T1Entity updatedT1 = _t1Repository.save(t1);
        return mapper.t1EntityToUpdateT1Output(updatedT1);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Long t1Id) {
        T1Entity existing = _t1Repository.findById(t1Id).orElse(null);

        _t1Repository.delete(existing);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public FindT1ByIdOutput findById(Long t1Id) {
        T1Entity foundT1 = _t1Repository.findById(t1Id).orElse(null);
        if (foundT1 == null) return null;

        return mapper.t1EntityToFindT1ByIdOutput(foundT1);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<FindT1ByIdOutput> find(SearchCriteria search, Pageable pageable) throws Exception {
        Page<T1Entity> foundT1 = _t1Repository.findAll(search(search), pageable);
        List<T1Entity> t1List = foundT1.getContent();
        Iterator<T1Entity> t1Iterator = t1List.iterator();
        List<FindT1ByIdOutput> output = new ArrayList<>();

        while (t1Iterator.hasNext()) {
            T1Entity t1 = t1Iterator.next();
            output.add(mapper.t1EntityToFindT1ByIdOutput(t1));
        }
        return output;
    }

    protected BooleanBuilder search(SearchCriteria search) throws Exception {
        QT1Entity t1 = QT1Entity.t1Entity;
        if (search != null) {
            Map<String, SearchFields> map = new HashMap<>();
            for (SearchFields fieldDetails : search.getFields()) {
                map.put(fieldDetails.getFieldName(), fieldDetails);
            }
            List<String> keysList = new ArrayList<String>(map.keySet());
            checkProperties(keysList);
            return searchKeyValuePair(t1, map, search.getJoinColumns());
        }
        return null;
    }

    protected void checkProperties(List<String> list) throws Exception {
        for (int i = 0; i < list.size(); i++) {
            if (
                !(
                    list.get(i).replace("%20", "").trim().equals("ca") ||
                    list.get(i).replace("%20", "").trim().equals("file") ||
                    list.get(i).replace("%20", "").trim().equals("flpa") ||
                    list.get(i).replace("%20", "").trim().equals("fpa") ||
                    list.get(i).replace("%20", "").trim().equals("id") ||
                    list.get(i).replace("%20", "").trim().equals("str")
                )
            ) {
                throw new Exception("Wrong URL Format: Property " + list.get(i) + " not found!");
            }
        }
    }

    protected BooleanBuilder searchKeyValuePair(
        QT1Entity t1,
        Map<String, SearchFields> map,
        Map<String, String> joinColumns
    ) {
        BooleanBuilder builder = new BooleanBuilder();

        for (Map.Entry<String, SearchFields> details : map.entrySet()) {
            if (details.getKey().replace("%20", "").trim().equals("id")) {
                if (details.getValue().getOperator().equals("contains")) {
                    builder.and(t1.id.like(details.getValue().getSearchValue() + "%"));
                } else if (
                    details.getValue().getOperator().equals("equals") &&
                    StringUtils.isNumeric(details.getValue().getSearchValue())
                ) {
                    builder.and(t1.id.eq(Long.valueOf(details.getValue().getSearchValue())));
                } else if (
                    details.getValue().getOperator().equals("notEqual") &&
                    StringUtils.isNumeric(details.getValue().getSearchValue())
                ) {
                    builder.and(t1.id.ne(Long.valueOf(details.getValue().getSearchValue())));
                } else if (details.getValue().getOperator().equals("range")) {
                    if (
                        StringUtils.isNumeric(details.getValue().getStartingValue()) &&
                        StringUtils.isNumeric(details.getValue().getEndingValue())
                    ) {
                        builder.and(
                            t1.id.between(
                                Long.valueOf(details.getValue().getStartingValue()),
                                Long.valueOf(details.getValue().getEndingValue())
                            )
                        );
                    } else if (StringUtils.isNumeric(details.getValue().getStartingValue())) {
                        builder.and(t1.id.goe(Long.valueOf(details.getValue().getStartingValue())));
                    } else if (StringUtils.isNumeric(details.getValue().getEndingValue())) {
                        builder.and(t1.id.loe(Long.valueOf(details.getValue().getEndingValue())));
                    }
                }
            }
        }

        return builder;
    }
}
