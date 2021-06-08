package com.iceond.ecargo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDocumentUserEntity is a Querydsl query type for DocumentUserEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDocumentUserEntity extends EntityPathBase<DocumentUserEntity> {

    private static final long serialVersionUID = -2121461148L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDocumentUserEntity documentUserEntity = new QDocumentUserEntity("documentUserEntity");

    public final QGenericEntity _super = new QGenericEntity(this);

    //inherited
    public final DateTimePath<java.sql.Timestamp> createdDate = _super.createdDate;

    public final QDocumentTypeEntity documentType;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final ArrayPath<Byte[], Byte> image = createArray("image", Byte[].class);

    //inherited
    public final DateTimePath<java.sql.Timestamp> updatedDate = _super.updatedDate;

    public final QUserEntity user;

    public QDocumentUserEntity(String variable) {
        this(DocumentUserEntity.class, forVariable(variable), INITS);
    }

    public QDocumentUserEntity(Path<? extends DocumentUserEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDocumentUserEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDocumentUserEntity(PathMetadata metadata, PathInits inits) {
        this(DocumentUserEntity.class, metadata, inits);
    }

    public QDocumentUserEntity(Class<? extends DocumentUserEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.documentType = inits.isInitialized("documentType") ? new QDocumentTypeEntity(forProperty("documentType"), inits.get("documentType")) : null;
        this.user = inits.isInitialized("user") ? new QUserEntity(forProperty("user")) : null;
    }

}

