package it.michelelacorte.retractabletoolbar;

/**
 * Created by Michele on 15/11/2015.
 */
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.animation.LinearInterpolator;

public final class RetractableToolbarUtil {

    public static class ShowHideToolbarOnScrollingListener extends RecyclerView.OnScrollListener {
        public static final String SHOW_HIDE_TOOLBAR_LISTENER_STATE = "show-hide-toolbar-listener-state";

        // Toolbar elevation when content is scrolled behind
        private static final float TOOLBAR_ELEVATION = 14f;

        private Toolbar toolbar;
        private State state;

        public ShowHideToolbarOnScrollingListener(Toolbar toolbar) {
            this.toolbar = toolbar;
            this.state = new State();
        }

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        private void toolbarSetElevation(float elevation) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                toolbar.setElevation(elevation == 0 ? 0 : TOOLBAR_ELEVATION);
            }
        }

        private void toolbarAnimateShow(final int verticalOffset) {
            toolbar.animate()
                    .translationY(0)
                    .setInterpolator(new LinearInterpolator())
                    .setDuration(180)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationStart(Animator animation) {
                            toolbarSetElevation(verticalOffset == 0 ? 0 : TOOLBAR_ELEVATION);
                        }
                    });
        }

        private void toolbarAnimateHide() {
            toolbar.animate()
                    .translationY(-toolbar.getHeight())
                    .setInterpolator(new LinearInterpolator())
                    .setDuration(180)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            toolbarSetElevation(0);
                        }
                    });
        }

        @Override
        public final void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                if (state.scrollingOffset > 0) {
                    if (state.verticalOffset > toolbar.getHeight()) {
                        toolbarAnimateHide();
                    } else {
                        toolbarAnimateShow(state.verticalOffset);
                    }
                } else if (state.scrollingOffset < 0) {
                    if (toolbar.getTranslationY() < toolbar.getHeight() * -0.6 && state.verticalOffset > toolbar.getHeight()) {
                        toolbarAnimateHide();
                    } else {
                        toolbarAnimateShow(state.verticalOffset);
                    }
                }
            }
        }

        @Override
        public final void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            state.verticalOffset = recyclerView.computeVerticalScrollOffset();
            state.scrollingOffset = dy;
            int toolbarYOffset = (int) (dy - toolbar.getTranslationY());
            toolbar.animate().cancel();
            if (state.scrollingOffset > 0) {
                if (toolbarYOffset < toolbar.getHeight()) {
                    if (state.verticalOffset > toolbar.getHeight()) {
                        toolbarSetElevation(TOOLBAR_ELEVATION);
                    }
                    toolbar.setTranslationY(state.translationY = -toolbarYOffset);
                } else {
                    toolbarSetElevation(0);
                    toolbar.setTranslationY(state.translationY = -toolbar.getHeight());
                }
            } else if (state.scrollingOffset < 0) {
                if (toolbarYOffset < 0) {
                    if (state.verticalOffset <= 0) {
                        toolbarSetElevation(0);
                    }
                    toolbar.setTranslationY(state.translationY = 0);
                } else {
                    if (state.verticalOffset > toolbar.getHeight()) {
                        toolbarSetElevation(TOOLBAR_ELEVATION);
                    }
                    toolbar.setTranslationY(state.translationY = -toolbarYOffset);
                }
            }
        }

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        public void onRestoreInstanceState(State state) {
            this.state.verticalOffset = state.verticalOffset;
            this.state.scrollingOffset = state.scrollingOffset;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                toolbar.setElevation(state.elevation);
                toolbar.setTranslationY(state.translationY);
            }
        }

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        public State onSaveInstanceState() {
            state.translationY = toolbar.getTranslationY();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                state.elevation = toolbar.getElevation();
            }
            return state;
        }

        /**
         * Saving and restoring current state.
         */
        public static final class State implements Parcelable {
            public static Creator<State> CREATOR = new Creator<State>() {
                public State createFromParcel(Parcel parcel) {
                    return new State(parcel);
                }

                public State[] newArray(int size) {
                    return new State[size];
                }
            };

            // Vertical offset in the list
            private int verticalOffset;
            // Scroll UP/DOWN offset
            private int scrollingOffset;
            // Toolbar values
            private float translationY;
            private float elevation;

            State() {
            }

            State(Parcel parcel) {
                this.verticalOffset = parcel.readInt();
                this.scrollingOffset = parcel.readInt();
                this.translationY = parcel.readFloat();
                this.elevation = parcel.readFloat();
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel parcel, int flags) {
                parcel.writeInt(verticalOffset);
                parcel.writeInt(scrollingOffset);
                parcel.writeFloat(translationY);
                parcel.writeFloat(elevation);
            }
        }
    }

    private RetractableToolbarUtil() {
    }
}