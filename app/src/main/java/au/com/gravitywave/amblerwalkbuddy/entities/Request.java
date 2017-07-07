package au.com.gravitywave.amblerwalkbuddy.entities;

import java.util.Date;

import au.com.gravitywave.amblerwalkbuddy.bases.EntityBase;

/**
 * Created by georg on 7/07/2017.
 */

public class Request extends EntityBase {

    private String requestId;
    private int requesterId;
    private String requesterName;
    private String fromPlaceId;
    private String fromName;
    private String fromAddress;
    private String toPlaceId;
    private String toName;
    private String toAddress;
    private Date time;
    private String note;
    private String walkBuddyId;
    private String walkBuddyName;
    private int walkBuddyImageId;
    private RequestStatus status;

    public Request(String requestId, int requesterId, String requesterName, String fromPlaceId, String fromName, String fromAddress, String toPlaceId, String toName, String toAddress, Date time, String note, String walkBuddyId, String walkBuddyName, int walkBuddyImageId, RequestStatus status) {
        this.requestId = requestId;
        this.requesterId = requesterId;
        this.requesterName = requesterName;
        this.fromPlaceId = fromPlaceId;
        this.fromName = fromName;
        this.fromAddress = fromAddress;
        this.toPlaceId = toPlaceId;
        this.toName = toName;
        this.toAddress = toAddress;
        this.time = time;
        this.note = note;
        this.walkBuddyId = walkBuddyId;
        this.walkBuddyName = walkBuddyName;
        this.walkBuddyImageId = walkBuddyImageId;
        this.status = status;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public int getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(int requesterId) {
        this.requesterId = requesterId;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    public String getFromPlaceId() {
        return fromPlaceId;
    }

    public void setFromPlaceId(String fromPlaceId) {
        this.fromPlaceId = fromPlaceId;
    }

    public String getFromName() {
        return fromName;
    }

    public void setFromName(String fromName) {
        this.fromName = fromName;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getToPlaceId() {
        return toPlaceId;
    }

    public void setToPlaceId(String toPlaceId) {
        this.toPlaceId = toPlaceId;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getWalkBuddyId() {
        return walkBuddyId;
    }

    public void setWalkBuddyId(String walkBuddyId) {
        this.walkBuddyId = walkBuddyId;
    }

    public String getWalkBuddyName() {
        return walkBuddyName;
    }

    public void setWalkBuddyName(String walkBuddyName) {
        this.walkBuddyName = walkBuddyName;
    }

    public int getWalkBuddyImageId() {
        return walkBuddyImageId;
    }

    public void setWalkBuddyImageId(int walkBuddyImageId) {
        this.walkBuddyImageId = walkBuddyImageId;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public enum RequestStatus {
        notStarted,
        waiting,
        walking,
        complete
    }

}
