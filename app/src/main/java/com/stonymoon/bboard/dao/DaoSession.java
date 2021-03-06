package com.stonymoon.bboard.dao;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import com.stonymoon.bboard.bean.ItunesSong;

import com.stonymoon.bboard.dao.ItunesSongDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig itunesSongDaoConfig;

    private final ItunesSongDao itunesSongDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        itunesSongDaoConfig = daoConfigMap.get(ItunesSongDao.class).clone();
        itunesSongDaoConfig.initIdentityScope(type);

        itunesSongDao = new ItunesSongDao(itunesSongDaoConfig, this);

        registerDao(ItunesSong.class, itunesSongDao);
    }
    
    public void clear() {
        itunesSongDaoConfig.clearIdentityScope();
    }

    public ItunesSongDao getItunesSongDao() {
        return itunesSongDao;
    }

}
