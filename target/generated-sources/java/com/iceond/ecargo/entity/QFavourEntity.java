package com.iceond.ecargo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFavourEntity is a Querydsl query type for FavourEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFavourEntity extends EntityPathBase<FavourEntity> {

    private static final long serialVersionUID = 1018645807L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFavourEntity favourEntity = new QFavourEntity("favourEntity");

    public final QGenericEntity _super = new QGenericEntity(this);

    public final QCategoryEntity category;

    //inherited
    public final DateTimePath<java.sql.Timestamp> createdDate = _super.createdDate;

    public final StringPath description = createString("description");

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final DateTimePath<java.sql.Timestamp> limitDate = createDateTime("limitDate", java.sql.Timestamp.class);

    public final DateTimePath<java.sql.Timestamp> payedDate = createDateTime("payedDate", java.sql.Timestamp.class);

    public final QStatusEntity status;

    public final StringPath ubication = createString("ubication");

    //inherited
    public final DateTimePath<java.sql.Timestamp> updatedDate = _super.updatedDate;

    public final QUserEntity user;

    public final QUserEntity worker;

    public QFavourEntity(String variable) {
        this(FavourEntity.class, forVariable(variable), INITS);
    }

    public QFavourEntity(Path<? extends FavourEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFavourEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFavourEntity(PathMetadata metadata, PathInits inits) {
        this(FavourEntity.class, metadata, inits);
    }

    public QFavourEntity(Class<? extends FavourEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QCategoryEntity(forProperty("category")) : null;
        this.status = inits.isInitialized("status") ? new QStatusEntity(forProperty("status")) : null;
        this.user = inits.isInitialized("user") ? new QUserEntity(forProperty("user")) : null;
        this.worker = inits.isInitialized("worker") ? new QUserEntity(forProperty("worker")) : null;
    }

}

