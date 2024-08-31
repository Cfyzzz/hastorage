package ru.nedovizin.model;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import ru.nedovizin.domain.tables.Category;
import ru.nedovizin.domain.tables.records.CategoryRecord;

import java.util.List;
import static org.jooq.impl.DSL.val;

@Repository
@Slf4j
@RequiredArgsConstructor
public class CategoryRepository {

    @Autowired
    private DSLContext dsl;

    @Autowired
    public void setDsl(DSLContext dsl) {
        this.dsl = dsl;
    }

    public void save(CategoryDTO categoryDTO) {
        Category category = Category.CATEGORY;
        dsl.insertInto(category)
                .set(category.OUTCATEGORYID, categoryDTO.getId())
                .set(category.TOKEN, categoryDTO.getToken())
                .set(category.PLANNED, categoryDTO.getPlanned())
                .set(category.PERIOD, categoryDTO.getPeriod())
                .set(category.EXPOSED, categoryDTO.getExposed())
                .set(category.CATEGORYNAME, categoryDTO.getCategoryName())
                .set(category.COLOR, categoryDTO.getColor())
                .set(category.RESERVED, categoryDTO.getReserved())
                .set(category.PRIORITY, categoryDTO.getPriority())
                .set(category.TYPE, categoryDTO.getType())
                .returning(category.ID)
                .fetchOne();

    }

    public List<CategoryDTO> findAllByToken (String token) {
        Category category = Category.CATEGORY;
        return dsl.selectFrom(category)
                .where(category.TOKEN.eq(token))
                .fetchInto(CategoryDTO.class);
    }
}
