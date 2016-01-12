package com.green.study.db;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.green.study.bean.UserInfo;

import com.green.study.db.UserInfoDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userInfoDaoConfig;

    private final UserInfoDao userInfoDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userInfoDaoConfig = daoConfigMap.get(UserInfoDao.class).clone();
        userInfoDaoConfig.initIdentityScope(type);

        userInfoDao = new UserInfoDao(userInfoDaoConfig, this);

        registerDao(UserInfo.class, userInfoDao);
    }
    
    public void clear() {
        userInfoDaoConfig.getIdentityScope().clear();
    }

    public UserInfoDao getUserInfoDao() {
        return userInfoDao;
    }

}
