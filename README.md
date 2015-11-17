# RetractableToolbar

[![alt tag](http://www.android-gems.com/badge/michelelacorte/RetractableToolbar.svg)](http://www.android-gems.com/lib/michelelacorte/RetractableToolbar?lib_id=709)

![alt tag](http://i.giphy.com/3oEduTiPtJGG9Q23Xq.gif)

Retractable Toolbar it is a utility to give the effect Retractable your toolbar!!

##USAGE

Retractable Toolbar is pushed to JCenter, so you just need to add the following dependency to your `build.gradle`.
```
compile 'it.michelelacorte.retractabletoolbar:library:1.0.0'
```

In alternative you can use AAR repository with:

```
allprojects {
    repositories {
        maven { url "https://dl.bintray.com/michelelacorte/maven/" }
        jcenter()
        mavenCentral()

    }
}
```

And add this dependecies

```
compile 'it.michelelacorte.retractabletoolbar:library:1.0.0@aar'
```

In your `MainActivity.java`

```
RetractableToolbarUtil.ShowHideToolbarOnScrollingListener showHideToolbarListener;
recyclerView.addOnScrollListener(showHideToolbarListener = new RetractableToolbarUtil.ShowHideToolbarOnScrollingListener(toolbar));

if (savedInstanceState != null) {
            showHideToolbarListener.onRestoreInstanceState((RetractableToolbarUtil.ShowHideToolbarOnScrollingListener.State) savedInstanceState
                    .getParcelable(RetractableToolbarUtil.ShowHideToolbarOnScrollingListener.SHOW_HIDE_TOOLBAR_LISTENER_STATE));
}
```

##SYSTEM REQUIREMENT

Android API 21+

##CHANGELOG

**v1.0.0**
- Support API 21+
- Support `RecyclerView` list

##CREDITS

Author: Michele Lacorte (micky1995g@gmail.com)

##LICENSE

```
Copyright 2015 Michele Lacorte

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
