package com.zzptc.sky.netnews.mvp.view;

import com.zzptc.sky.netnews.greendao.NewsChannelTable;
import com.zzptc.sky.netnews.mvp.view.base.BaseView;

import java.util.List;

/**
 * Created by Hu Zhilin on 2016/10/31.
 */

public interface NewsView extends BaseView {

    void initViewPager(List<NewsChannelTable> newsChannelTables);
}
