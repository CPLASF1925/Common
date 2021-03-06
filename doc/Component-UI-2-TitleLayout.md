## ------ TitleLayout标题栏使用 ------

#### 1. Xml布局中添加
```xml
    <com.d.lib.common.view.TitleLayout
        android:id="@+id/tl_title"
        android:layout_width="match_parent"
        android:layout_height="@dimen/lib_pub_dimen_title_height"
        android:background="@color/lib_pub_color_main"
        app:lib_pub_tl_leftDrawable="@drawable/lib_pub_ic_title_back"
        app:lib_pub_tl_middleText="Title" />
```

#### 2. 获取引用
```xml
    @Bind(R.id.tl_title)
    TitleLayout tlTitle;
```

#### 3. 方法
```xml
    1).findViewById(...)
    2).setOnClickListener(...)
    3).setVisibility(int resId, int visibility)
    4).setText(int resId, CharSequence text)
    5).setOnClickListener(int resId, OnClickListener l)
```

#### 4. 对照表(属性-Id)
| Attrs                         | Id               |
| ----------------------------- |:----------------:|
|    lib_pub_tl_leftText        |  tv_title_left   |
|    lib_pub_tl_leftDrawable    |  iv_title_left   |
|    lib_pub_tl_leftRes         |  reference       |
|    lib_pub_tl_rightText       |  tv_title_right  |
|    lib_pub_tl_rightDrawable   |  iv_title_right  |
|    lib_pub_tl_rightRes        |  reference       |
|    lib_pub_tl_middleText      |  tv_title_title  |
|    lib_pub_tl_middleDrawable  |  iv_title_middle |
|    lib_pub_tl_middleRes       |  reference       |
