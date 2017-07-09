package au.com.gravitywave.amblerwalkbuddy.requests;

import java.util.List;

import au.com.gravitywave.amblerwalkbuddy.entities.Request;

/**
 * Created by georg on 8/07/2017.
 */

public interface IRequestsView {
    void showRequests(List<Request> currentRequests);
}
