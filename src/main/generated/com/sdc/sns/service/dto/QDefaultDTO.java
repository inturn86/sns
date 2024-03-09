package com.sdc.sns.service.dto;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QDefaultDTO is a Querydsl query type for DefaultDTO
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QDefaultDTO extends EntityPathBase<DefaultDTO> {

    private static final long serialVersionUID = 1313454661L;

    public static final QDefaultDTO defaultDTO = new QDefaultDTO("defaultDTO");

    public final DateTimePath<java.time.LocalDateTime> createdDt = createDateTime("createdDt", java.time.LocalDateTime.class);

    public final DateTimePath<java.time.LocalDateTime> updatedDt = createDateTime("updatedDt", java.time.LocalDateTime.class);

    public QDefaultDTO(String variable) {
        super(DefaultDTO.class, forVariable(variable));
    }

    public QDefaultDTO(Path<? extends DefaultDTO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDefaultDTO(PathMetadata metadata) {
        super(DefaultDTO.class, metadata);
    }

}

