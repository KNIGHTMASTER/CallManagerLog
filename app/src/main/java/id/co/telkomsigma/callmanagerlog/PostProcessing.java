package id.co.telkomsigma.callmanagerlog;

/**
 * Created on 4/15/2016 : 10:55 AM.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface PostProcessing<DATA> {

    void onPostProcess(DATA data);
}
