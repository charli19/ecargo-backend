package com.iceond.ecargo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStatusEntity is a Querydsl query type for StatusEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QStatusEntity extends EntityPathBase<StatusEntity> {

    private static final long serialVersionUID = -1108601328L;

    public static final QStatusEntity statusEntity = new QStatusEntity("statusEntity");

    public final QGenericEntity _super = new QGenericEntity(this);

    //inherited
    public final DateTimePath<java.sql.Timestamp> createdDate = _super.createdDate;

    public final SetPath<FavourEntity, QFavourEntity> favour = this.<FavourEntity, QFavourEntity>createSet("favour", FavourEntity.class, QFavourEntity.class, PathInits.DIRECT2);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.sql.Timestamp> updatedDate = _super.updatedDate;

    public QStatusEntity(String variable) {
        super(StatusEntity.class, forVariable(variable));
    }

    public QStatusEntity(Path<? extends StatusEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStatusEntity(PathMetadata metadata) {
        super(StatusEntity.class, metadata);
    }

}

