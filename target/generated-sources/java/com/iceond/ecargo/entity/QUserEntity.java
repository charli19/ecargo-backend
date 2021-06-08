package com.iceond.ecargo.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserEntity is a Querydsl query type for UserEntity
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserEntity extends EntityPathBase<UserEntity> {

    private static final long serialVersionUID = -1346677271L;

    public static final QUserEntity userEntity = new QUserEntity("userEntity");

    public final QGenericEntity _super = new QGenericEntity(this);

    public final StringPath biography = createString("biography");

    public final DateTimePath<java.util.Date> birthdayDate = createDateTime("birthdayDate", java.util.Date.class);

    //inherited
    public final DateTimePath<java.sql.Timestamp> createdDate = _super.createdDate;

    public final StringPath email = createString("thymeleaf.email");

    public final SetPath<FavourEntity, QFavourEntity> favours = this.<FavourEntity, QFavourEntity>createSet("favours", FavourEntity.class, QFavourEntity.class, PathInits.DIRECT2);

    //inherited
    public final NumberPath<Long> id = _super.id;

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final SetPath<PaymentMethodEntity, QPaymentMethodEntity> paymentMethod = this.<PaymentMethodEntity, QPaymentMethodEntity>createSet("paymentMethod", PaymentMethodEntity.class, QPaymentMethodEntity.class, PathInits.DIRECT2);

    public final SetPath<PermissionEntity, QPermissionEntity> permissions = this.<PermissionEntity, QPermissionEntity>createSet("permissions", PermissionEntity.class, QPermissionEntity.class, PathInits.DIRECT2);

    public final StringPath phoneNumber = createString("phoneNumber");

    public final StringPath surname = createString("surname");

    //inherited
    public final DateTimePath<java.sql.Timestamp> updatedDate = _super.updatedDate;

    public final StringPath username = createString("username");

    public final SetPath<FavourEntity, QFavourEntity> workerFavours = this.<FavourEntity, QFavourEntity>createSet("workerFavours", FavourEntity.class, QFavourEntity.class, PathInits.DIRECT2);

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

