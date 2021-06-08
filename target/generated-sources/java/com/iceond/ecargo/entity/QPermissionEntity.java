package com.iceond.ecargo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPermissionEntity is a Querydsl query type for PermissionEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPermissionEntity extends EntityPathBase<PermissionEntity> {

    private static final long serialVersionUID = 74460333L;

    public static final QPermissionEntity permissionEntity = new QPermissionEntity("permissionEntity");

    public final QGenericEntity _super = new QGenericEntity(this);

    //inherited
    public final DateTimePath<java.sql.Timestamp> createdDate = _super.createdDate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.sql.Timestamp> updatedDate = _super.updatedDate;

    public final SetPath<UserEntity, QUserEntity> users = this.<UserEntity, QUserEntity>createSet("users", UserEntity.class, QUserEntity.class, PathInits.DIRECT2);

    public QPermissionEntity(String variable) {
        super(PermissionEntity.class, forVariable(variable));
    }

    public QPermissionEntity(Path<? extends PermissionEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPermissionEntity(PathMetadata metadata) {
        super(PermissionEntity.class, metadata);
    }

}

