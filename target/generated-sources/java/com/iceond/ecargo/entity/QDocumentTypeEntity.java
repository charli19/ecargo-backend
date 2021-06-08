package com.iceond.ecargo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDocumentTypeEntity is a Querydsl query type for DocumentTypeEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDocumentTypeEntity extends EntityPathBase<DocumentTypeEntity> {

    private static final long serialVersionUID = -841341293L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDocumentTypeEntity documentTypeEntity = new QDocumentTypeEntity("documentTypeEntity");

    public final QGenericEntity _super = new QGenericEntity(this);

    //inherited
    public final DateTimePath<java.sql.Timestamp> createdDate = _super.createdDate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.sql.Timestamp> updatedDate = _super.updatedDate;

    public final QUserEntity user;

    public QDocumentTypeEntity(String variable) {
        this(DocumentTypeEntity.class, forVariable(variable), INITS);
    }

    public QDocumentTypeEntity(Path<? extends DocumentTypeEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDocumentTypeEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDocumentTypeEntity(PathMetadata metadata, PathInits inits) {
        this(DocumentTypeEntity.class, metadata, inits);
    }

    public QDocumentTypeEntity(Class<? extends DocumentTypeEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUserEntity(forProperty("user")) : null;
    }

}

