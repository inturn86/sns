package com.sdc.sns.domain.usernamechangehistory;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserNameChangeHistory is a Querydsl query type for UserNameChangeHistory
 */
@Generated("com.querydsl.codegen.DefaultSupertypeSerializer")
public class QUserNameChangeHistory extends EntityPathBase<UserNameChangeHistory> {

    private static final long serialVersionUID = 1630797059L;

    public static final QUserNameChangeHistory userNameChangeHistory = new QUserNameChangeHistory("userNameChangeHistory");

    public final com.sdc.sns.service.dto.QDefaultDTO _super = new com.sdc.sns.service.dto.QDefaultDTO(this);

    public final StringPath afterUserName = createString("afterUserName");

    public final StringPath beforeUserName = createString("beforeUserName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDt = _super.createdDt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedDt = _super.updatedDt;

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final NumberPath<Long> userNameChangeHistoryId = createNumber("userNameChangeHistoryId", Long.class);

    public QUserNameChangeHistory(String variable) {
        super(UserNameChangeHistory.class, forVariable(variable));
    }

    public QUserNameChangeHistory(Path<? extends UserNameChangeHistory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserNameChangeHistory(PathMetadata metadata) {
        super(UserNameChangeHistory.class, metadata);
    }

}

