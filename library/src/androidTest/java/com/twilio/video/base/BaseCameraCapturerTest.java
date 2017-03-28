package com.twilio.video.base;

import android.support.test.rule.ActivityTestRule;

import com.twilio.video.CameraCapturer;
import com.twilio.video.LocalMedia;
import com.twilio.video.LocalVideoTrack;
import com.twilio.video.LogLevel;
import com.twilio.video.Video;
import com.twilio.video.ui.CameraCapturerTestActivity;
import com.twilio.video.util.FrameCountRenderer;
import com.twilio.video.util.PermissionUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

public abstract class BaseCameraCapturerTest {
    protected static final int CAMERA_CAPTURE_DELAY_MS = 3000;

    @Rule
    public ActivityTestRule<CameraCapturerTestActivity> activityRule =
            new ActivityTestRule<>(CameraCapturerTestActivity.class);
    protected CameraCapturerTestActivity cameraCapturerActivity;
    protected LocalMedia localMedia;
    protected CameraCapturer cameraCapturer;
    protected LocalVideoTrack localVideoTrack;
    protected FrameCountRenderer frameCountRenderer;

    @Before
    public void setup() {
        cameraCapturerActivity = activityRule.getActivity();
        PermissionUtils.allowPermissions(cameraCapturerActivity);
        localMedia = LocalMedia.create(cameraCapturerActivity);
        Video.setLogLevel(LogLevel.ALL);
        frameCountRenderer = new FrameCountRenderer();
    }

    @After
    public void teardown() {
        if (localMedia != null) {
            localMedia.removeVideoTrack(localVideoTrack);
            localMedia.release();
        }
    }
}
