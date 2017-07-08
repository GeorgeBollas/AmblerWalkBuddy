package au.com.gravitywave.amblerwalkbuddy.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import au.com.gravitywave.amblerwalkbuddy.bases.RepositoryBase;
import au.com.gravitywave.amblerwalkbuddy.entities.Request;

/**
 * Created by georg on 7/07/2017.
 */

public class RequestRepository
        extends RepositoryBase
        implements IRequestRepository
{

    private List<Request> mRequests;

    public RequestRepository() {

        mRequests = new ArrayList<>();

        mRequests.add(new Request(1,1,"Jane","FPID","Link Clug","the Street","TPID","Home","home address", new Date(),"note",100,"John",100, Request.RequestStatus.offered));
        mRequests.add(new Request(2,2,"Mary","FPID","Monvale Restaurant","the Street","TPID","Home","home address", new Date(),"note",100,"John",1, Request.RequestStatus.offered));
        mRequests.add(new Request(3,3,"Jane","FPID","Link Clug","the Street","TPID","Home","home address", new Date(),"note",101,"John",101, Request.RequestStatus.requested));
        mRequests.add(new Request(4,4,"Jane","FPID","Link Clug","the Street","TPID","Home","home address", new Date(),"note",102,"John",102, Request.RequestStatus.requested));
    }

    @Override
    public Request GetRequest(int id) {
        for (Request r :mRequests) {
            if (r.getRequestId() == id)
                return r;
        }

        return null;
    }

    @Override
    public List<Request> GetRequests() {
        return mRequests;
    }

    @Override
    public List<Request> GetWaitingRequests() {
        List<Request> result = new ArrayList<>();

        for (Request r : mRequests) {
            if (r.getStatus() == Request.RequestStatus.requested)
                result.add(r);
        }

        return result;
    }

    @Override
    public List<Request> GetMyOffers(final int myId) {
        List<Request> result = new ArrayList<>();

        for (Request r : mRequests) {
            if (r.getWalkBuddyId() == myId)
                result.add(r);
        }

        return result;
    }
}
