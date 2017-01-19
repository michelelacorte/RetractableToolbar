# RetractableToolbar

[![Twitter](https://img.shields.io/badge/Twitter-@LacorteMichele-blue.svg?style=flat)](https://twitter.com/LacorteMichele)

[![API](https://img.shields.io/badge/API-21%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=21)

[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-RetractableToolbar-brightgreen.svg?style=flat)](http://android-arsenal.com/details/1/2844)

[![alt tag](http://www.android-gems.com/badge/michelelacorte/RetractableToolbar.svg)](http://www.android-gems.com/lib/michelelacorte/RetractableToolbar?lib_id=709)

Retractable Toolbar it is a utility to give the effect Retractable your toolbar!!

![alt tag](https://github.com/michelelacorte/RetractableToolbar/blob/master/RetractableToolbarExample.gif)


##DONATIONS

This project needs you! If you would like to support this project's further development, the creator of this project or the continuous maintenance of this project, feel free to donate. Your donation is highly appreciated (and I love food, coffee and beer). Thank you!

**PayPal**

* **[Donate $5]**: Thank's for creating this project, here's a coffee (or some beer) for you!

* **[Donate $10]**: Wow, I am stunned. Let me take you to the movies!ù

* **[Donate $15]**: I really appreciate your work, let's grab some lunch!

* **[Donate $25]**: That's some awesome stuff you did right there, dinner is on me!

* **[Donate $50]**: I really really want to support this project, great job!

* **[Donate $100]**: You are the man! This project saved me hours (if not days) of struggle and hard work, simply awesome!

* **[Donate $2799]**: Go buddy, buy Macbook Pro for yourself!

Of course, you can also choose what you want to donate, all donations are awesome!! Follow this link [Donate](https://www.paypal.me/MicheleLacorte)!!

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

Follow my [Google+](https://plus.google.com/u/0/collection/McidZB)

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

[Donate $5]: 		https://www.paypal.me/MicheleLacorte/5
[Donate $10]:  		https://www.paypal.me/MicheleLacorte/10
[Donate $15]:  		https://www.paypal.me/MicheleLacorte/15
[Donate $25]:  		https://www.paypal.me/MicheleLacorte/25
[Donate $50]: 		https://www.paypal.me/MicheleLacorte/50
[Donate $100]: 		https://www.paypal.me/MicheleLacorte/100
[Donate $2799]: 	https://www.paypal.me/MicheleLacorte/2799
