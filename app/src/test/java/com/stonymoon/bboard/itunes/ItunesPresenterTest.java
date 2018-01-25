package com.stonymoon.bboard.itunes;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.any;

import java.util.ArrayList;
import java.util.List;


public class ItunesPresenterTest {
    @Mock
    private ItunesContract.View view;

    @Before
    public void setup() {

        MockitoAnnotations.initMocks(this);

    }


    @Test
    public void testLoadItunes() throws Exception {
        ItunesPresenter presenter = new ItunesPresenter(view);
        presenter.loadItunes();
        Mockito.verify(view).setPresenter(presenter);
        Mockito.verify(view).showItunesList(any(List.class));

    }


}
