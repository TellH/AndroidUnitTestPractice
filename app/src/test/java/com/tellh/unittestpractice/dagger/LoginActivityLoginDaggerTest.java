package com.tellh.unittestpractice.dagger;

import android.content.Context;

import com.tellh.unittestpractice.BuildConfig;
import com.tellh.unittestpractice.rule.ContextRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import it.cosenonjaviste.daggermock.DaggerMockRule;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;

/**
 * Created by tlh on 2017/4/18 :)
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class LoginActivityLoginDaggerTest {
    @Rule
    public final ContextRule contextRule = new ContextRule();
    Context context;
    @Rule
    public final DaggerMockRule<AppComponent> rule =
            new DaggerMockRule<>(AppComponent.class, new AppModule(context))
                    .set(new DaggerMockRule.ComponentSetter<AppComponent>() {
                        @Override
                        public void setComponent(AppComponent component) {
                            ComponentHolder.setAppComponent(component);
                        }
                    });
    @Mock
    LoginPresenter presenter;

    @Test
    public void testOnClick() {
        AppModule appModule = Mockito.spy(new AppModule(RuntimeEnvironment.application));
        LoginPresenter mockedPresenter = Mockito.mock(LoginPresenter.class);
        Mockito.when(appModule.provideLoginPresenter(any(UserManager.class))).thenReturn(mockedPresenter);
        AppComponent appComponent = DaggerAppComponent.builder().appModule(appModule).build();
        ComponentHolder.setAppComponent(appComponent);
        LoginActivity loginActivity = Robolectric.setupActivity(LoginActivity.class);
        loginActivity.edtUsername.setText("TellH");
        loginActivity.edtPassword.setText("a123456");
        loginActivity.btnLogin.performClick();
        Mockito.verify(mockedPresenter).login(eq("TellH"), eq("a123456"), any(LoginPresenter.LoginCallback.class));
    }

    @Test
    public void testDaggerMock() {
        LoginActivity loginActivity = Robolectric.setupActivity(LoginActivity.class);
        loginActivity.edtUsername.setText("TellH");
        loginActivity.edtPassword.setText("a123456");
        loginActivity.btnLogin.performClick();
        Mockito.verify(presenter).login(eq("TellH"), eq("a123456"), any(LoginPresenter.LoginCallback.class));
    }

}