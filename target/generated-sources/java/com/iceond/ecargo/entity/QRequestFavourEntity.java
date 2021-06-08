package com.iceond.ecargo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRequestFavourEntity is a Querydsl query type for RequestFavourEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRequestFavourEntity extends EntityPathBase<RequestFavourEntity> {

    private static final long serialVersionUID = 1266719176L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRequestFavourEntity requestFavourEntity = new QRequestFavourEntity("requestFavourEntity");

    public final QGenericEntity _super = new QGenericEntity(this);

    //inherited
    public final DateTimePath<java.sql.Timestamp> createdDate = _super.createdDate;

    public final QFavourEntity favour;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath observation = createString("observation");

    public final NumberPath<Double> price = createNumber("price", Double.class);

    //inherited
    public final DateTimePath<java.sql.Timestamp> updatedDate = _super.updatedDate;

    public final QUserEntity worker;

    public QRequestFavourEntity(String variable) {
        this(RequestFavourEntity.class, forVariable(variable), INITS);
    }

    public QRequestFavourEntity(Path<? extends RequestFavourEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRequestFavourEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRequestFavourEntity(PathMetadata metadata, PathInits inits) {
        this(RequestFavourEntity.class, metadata, inits);
    }

    public QRequestFavourEntity(Class<? extends RequestFavourEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.favour = inits.isInitialized("favour") ? new QFavourEntity(forProperty("favour"), inits.get("favour")) : null;
        this.worker = inits.isInitialized("worker") ? new QUserEntity(forProperty("worker")) : null;
    }

}

