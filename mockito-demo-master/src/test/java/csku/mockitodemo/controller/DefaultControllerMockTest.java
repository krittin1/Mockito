package csku.mockitodemo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DefaultControllerMockTest {

    @Mock private Request stubRequest;
    @Mock private Response stubResponse;
    @Mock private RequestHandler mockHandler;

    // class under test (CUT)
    private Controller controller;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.initMocks(this);
        controller = new DefaultController();
    }

    @Test
    void testProcessCallsHandlerProcess() throws Exception {

        // stubbing
        when(stubRequest.getName()).thenReturn("Test");
        when(mockHandler.process(any())).thenReturn(stubResponse);

        // using mock object
        controller.addHandler(stubRequest, mockHandler);
        Response result = controller.processRequest(stubRequest);

        // verify
        verify(mockHandler).process(stubRequest);

        assertSame(stubResponse, result);
    }

}
