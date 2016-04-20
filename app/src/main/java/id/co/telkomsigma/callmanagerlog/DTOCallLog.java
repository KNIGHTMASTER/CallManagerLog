package id.co.telkomsigma.callmanagerlog;

import java.util.Date;

/**
 * Created on 4/15/2016 : 10:51 AM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class DTOCallLog {

    private String number;
    private String type;
    private String date;
    private String duration;
    private String direction;
    private Date callDayTime;
    private String cachedFormattedNumber;
    private String cachedLookUpURI;
    private String cachedMatchedNumber;
    private String cachedName;
    private String normalizedNumber;
    private String cachedNumberLevel;
    private String cachedNumberType;
    private String cachedPhotoId;
    private String geocodedLocation;
    private String countryIso;
    private String isRead;
    private String isNew;
    private String presentationOfNumber;

    public Date getCallDayTime() {
        return callDayTime;
    }

    public void setCallDayTime(Date callDayTime) {
        this.callDayTime = callDayTime;
    }

    public String getCachedFormattedNumber() {
        return cachedFormattedNumber;
    }

    public void setCachedFormattedNumber(String cachedFormattedNumber) {
        this.cachedFormattedNumber = cachedFormattedNumber;
    }

    public String getCachedLookUpURI() {
        return cachedLookUpURI;
    }

    public void setCachedLookUpURI(String cachedLookUpURI) {
        this.cachedLookUpURI = cachedLookUpURI;
    }

    public String getCachedMatchedNumber() {
        return cachedMatchedNumber;
    }

    public void setCachedMatchedNumber(String cachedMatchedNumber) {
        this.cachedMatchedNumber = cachedMatchedNumber;
    }

    public String getCachedName() {
        return cachedName;
    }

    public void setCachedName(String cachedName) {
        this.cachedName = cachedName;
    }

    public String getNormalizedNumber() {
        return normalizedNumber;
    }

    public void setNormalizedNumber(String normalizedNumber) {
        this.normalizedNumber = normalizedNumber;
    }

    public String getCachedNumberLevel() {
        return cachedNumberLevel;
    }

    public void setCachedNumberLevel(String cachedNumberLevel) {
        this.cachedNumberLevel = cachedNumberLevel;
    }

    public String getCachedNumberType() {
        return cachedNumberType;
    }

    public void setCachedNumberType(String cachedNumberType) {
        this.cachedNumberType = cachedNumberType;
    }

    public String getCachedPhotoId() {
        return cachedPhotoId;
    }

    public void setCachedPhotoId(String cachedPhotoId) {
        this.cachedPhotoId = cachedPhotoId;
    }

    public String getGeocodedLocation() {
        return geocodedLocation;
    }

    public void setGeocodedLocation(String geocodedLocation) {
        this.geocodedLocation = geocodedLocation;
    }

    public String getCountryIso() {
        return countryIso;
    }

    public void setCountryIso(String countryIso) {
        this.countryIso = countryIso;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public String getIsNew() {
        return isNew;
    }

    public void setIsNew(String isNew) {
        this.isNew = isNew;
    }

    public String getPresentationOfNumber() {
        return presentationOfNumber;
    }

    public void setPresentationOfNumber(String presentationOfNumber) {
        this.presentationOfNumber = presentationOfNumber;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

}
