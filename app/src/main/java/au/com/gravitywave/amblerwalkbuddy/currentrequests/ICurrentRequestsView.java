package au.com.gravitywave.amblerwalkbuddy.currentrequests;

import java.util.List;

import au.com.gravitywave.amblerwalkbuddy.entities.Request;

/**
 * Created by georg on 8/07/2017.
 */

public interface ICurrentRequestsView {
    void ShowCurrentRequests(List<Request> currentRequests);
}
