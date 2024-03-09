package com.sdc.sns.domain.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserEntity is a Querydsl query type for UserEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserEntity extends EntityPathBase<UserEntity> {

    private static final long serialVersionUID = -373531898L;

    public static final QUserEntity userEntity = new QUserEntity("userEntity");

    public final QUser _super = new QUser(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDt = _super.createdDt;

    //inherited
    public final StringPath email = _super.email;

    //inherited
    public final StringPath password = _super.password;

    //inherited
    public final StringPath phone = _super.phone;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedDt = _super.updatedDt;

    //inherited
    public final NumberPath<Long> userId = _super.userId;

    //inherited
    public final StringPath userName = _super.userName;

    public QUserEntity(String variable) {
        super(UserEntity.class, forVariable(variable));
    }

    public QUserEntity(Path<? extends UserEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserEntity(PathMetadata metadata) {
        super(UserEntity.class, metadata);
    }

}

