package com.iceond.ecargo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPaymentMethodEntity is a Querydsl query type for PaymentMethodEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPaymentMethodEntity extends EntityPathBase<PaymentMethodEntity> {

    private static final long serialVersionUID = -328369841L;

    public static final QPaymentMethodEntity paymentMethodEntity = new QPaymentMethodEntity("paymentMethodEntity");

    public final QGenericEntity _super = new QGenericEntity(this);

    //inherited
    public final DateTimePath<java.sql.Timestamp> createdDate = _super.createdDate;

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.sql.Timestamp> updatedDate = _super.updatedDate;

    public final SetPath<UserEntity, QUserEntity> users = this.<UserEntity, QUserEntity>createSet("users", UserEntity.class, QUserEntity.class, PathInits.DIRECT2);

    public QPaymentMethodEntity(String variable) {
        super(PaymentMethodEntity.class, forVariable(variable));
    }

    public QPaymentMethodEntity(Path<? extends PaymentMethodEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPaymentMethodEntity(PathMetadata metadata) {
        super(PaymentMethodEntity.class, metadata);
    }

}

