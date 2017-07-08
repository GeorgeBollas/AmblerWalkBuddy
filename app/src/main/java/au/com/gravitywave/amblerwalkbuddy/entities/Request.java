package au.com.gravitywave.amblerwalkbuddy.entities;

import java.util.Date;

import au.com.gravitywave.amblerwalkbuddy.bases.EntityBase;

/**
 * Created by georg on 7/07/2017.
 */

public class Request extends EntityBase {

    private int requestId;

    private int requesterId;
    private String requesterName;

    private String fromPlaceId;
    private String fromPlaceName;
    private String fromAddress;

    private String toPlaceId;
    private String toPlaceName;
    private String toAddress;

    private Date time;
    private String note;

    private int walkBuddyId;
    private String walkBuddyName;
    private int walkBuddyImageId;

    private RequestStatus status;

    public Request(int requestId, int requesterId, String requesterName, String fromPlaceId, String fromPlaceName, String fromAddress, String toPlaceId, String toPlaceName, String toAddress, Date time, String note, int walkBuddyId, String walkBuddyName, int walkBuddyImageId, RequestStatus status) {
        this.requestId = requestId;
        this.requesterId = requesterId;
        this.requesterName = requesterName;
        this.fromPlaceId = fromPlaceId;
        this.fromPlaceName = fromPlaceName;
        this.fromAddress = fromAddress;
        this.toPlaceId = toPlaceId;
        this.toPlaceName = toPlaceName;
        this.toAddress = toAddress;
        this.time = time;
        this.note = note;
        this.walkBuddyId = walkBuddyId;
        this.walkBuddyName = walkBuddyName;
        this.walkBuddyImageId = walkBuddyImageId;
        this.status = status;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
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

    public String getFromPlaceName() {
        return fromPlaceName;
    }

    public void setFromPlaceName(String fromPlaceName) {
        this.fromPlaceName = fromPlaceName;
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

    public String getToPlaceName() {
        return toPlaceName;
    }

    public void setToPlaceName(String toPlaceName) {
        this.toPlaceName = toPlaceName;
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

    public int getWalkBuddyId() {
        return walkBuddyId;
    }

    public void setWalkBuddyId(int walkBuddyId) {
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
        requested,
        offered,
        waiting,
        walking,
        complete
    }

}
