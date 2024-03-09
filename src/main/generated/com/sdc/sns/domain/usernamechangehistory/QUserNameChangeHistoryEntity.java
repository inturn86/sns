package com.sdc.sns.domain.usernamechangehistory;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserNameChangeHistoryEntity is a Querydsl query type for UserNameChangeHistoryEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserNameChangeHistoryEntity extends EntityPathBase<UserNameChangeHistoryEntity> {

    private static final long serialVersionUID = 305643206L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserNameChangeHistoryEntity userNameChangeHistoryEntity = new QUserNameChangeHistoryEntity("userNameChangeHistoryEntity");

    public final QUserNameChangeHistory _super = new QUserNameChangeHistory(this);

    //inherited
    public final StringPath afterUserName = _super.afterUserName;

    //inherited
    public final StringPath beforeUserName = _super.beforeUserName;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDt = _super.createdDt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedDt = _super.updatedDt;

    public final com.sdc.sns.domain.user.QUserEntity user;

    //inherited
    public final NumberPath<Long> userId = _super.userId;

    //inherited
    public final NumberPath<Long> userNameChangeHistoryId = _super.userNameChangeHistoryId;

    public QUserNameChangeHistoryEntity(String variable) {
        this(UserNameChangeHistoryEntity.class, forVariable(variable), INITS);
    }

    public QUserNameChangeHistoryEntity(Path<? extends UserNameChangeHistoryEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserNameChangeHistoryEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserNameChangeHistoryEntity(PathMetadata metadata, PathInits inits) {
        this(UserNameChangeHistoryEntity.class, metadata, inits);
    }

    public QUserNameChangeHistoryEntity(Class<? extends UserNameChangeHistoryEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new com.sdc.sns.domain.user.QUserEntity(forProperty("user")) : null;
    }

}

