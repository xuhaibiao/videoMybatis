package com.xu.videorental.util;

import com.xu.videorental.doMain.table.RecordInfo;
import com.xu.videorental.doMain.table.UserInfo;
import com.xu.videorental.doMain.table.VideoInfo;
import com.xu.videorental.doMain.view.AllFile;
import com.xu.videorental.doMain.view.UserRentalHistory;
import com.xu.videorental.doMain.view.VacantFile;
import com.xu.videorental.doMain.view.VideoRecording;
import com.xu.videorental.doMain.vo.NoReturnInfo;
import com.xu.videorental.service.ManagerService;
import com.xu.videorental.service.UserService;
import com.xu.videorental.service.impl.ManagerServiceImpl;
import com.xu.videorental.service.impl.UserServiceImpl;

import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 22:34 2019/11/30
 * @modified By
 */
public class GetDataUtil {
    private static UserService userService = new UserServiceImpl();
    private static ManagerService managerService = new ManagerServiceImpl();
    public static Object[][] getRecordData(String username) {
        List<UserRentalHistory> allRecording = userService.findAllRecording(username);
        Object[][] recordingData = new Object[allRecording.size()][6];
        for (int i = 0; i < allRecording.size(); i++) {
            recordingData[i][0] = allRecording.get(i).getName();
            recordingData[i][1] = allRecording.get(i).getFid();
            recordingData[i][2] = allRecording.get(i).getLend();
            recordingData[i][3] = allRecording.get(i).getDeposit();
            recordingData[i][4] = allRecording.get(i).getBack();
            recordingData[i][5] = allRecording.get(i).getAmount();
        }
        return recordingData;
    }

    public static Object[][] getNoReturnData(String username) {
        List<NoReturnInfo> allNoReturn = userService.findAllNoReturn(username);
        Object[][] noReturnData = new Object[allNoReturn.size()][5];
        for (int i = 0; i < allNoReturn.size(); i++) {
            noReturnData[i][0] = allNoReturn.get(i).getName();
            noReturnData[i][1] = allNoReturn.get(i).getFid();
            noReturnData[i][2] = allNoReturn.get(i).getLend();
            noReturnData[i][3] = allNoReturn.get(i).getDeposit();
            noReturnData[i][4] = allNoReturn.get(i).getAmount();

        }
        return noReturnData;
    }

    public static Object[][] getVacantFileData() {
        List<VacantFile> allVacantFile = userService.findAllVacantFile();
        Object[][] vacantFileData = new Object[allVacantFile.size()][3];
        for (int i = 0; i < allVacantFile.size(); i++) {
            vacantFileData[i][0] = allVacantFile.get(i).getName();
            vacantFileData[i][1] = allVacantFile.get(i).getPrice();
            vacantFileData[i][2] = allVacantFile.get(i).getFid();
        }
        return vacantFileData;
    }


    //管理员

    public static Object[][] getVideoData() {
        List<VideoInfo> videoInfos = managerService.findAllVideoInfo();
        Object[][] videoData = new Object[videoInfos.size()][4];
        for (int i = 0; i < videoInfos.size(); i++) {
            videoData[i][0] = videoInfos.get(i).getId();
            videoData[i][1] = videoInfos.get(i).getName();
            videoData[i][2] = videoInfos.get(i).getPrice();
            videoData[i][3] = videoInfos.get(i).getInventory();
        }
        return videoData;
    }

    public static Object[][] getFileData() {
        String[] tag = new String[]{"已出借", "空闲中"};
        List<AllFile> allFile = managerService.findAllFile();
        Object[][] fileData = new Object[allFile.size()][4];
        for (int i = 0; i < allFile.size(); i++) {
            fileData[i][0] = allFile.get(i).getId();
            fileData[i][1] = allFile.get(i).getVid();
            fileData[i][2] = allFile.get(i).getName();
            if (allFile.get(i).getStatus() == 1) {
                fileData[i][3] = tag[1];
            } else {
                fileData[i][3] = tag[0];
            }

        }
        return fileData;
    }

    public static Object[][] getAllUserRecordData() {
        List<RecordInfo> allRecording = managerService.findAllRecording();
        Object[][] recordingData = new Object[allRecording.size()][7];
        for (int i = 0; i < allRecording.size(); i++) {
            recordingData[i][0] = allRecording.get(i).getId();
            recordingData[i][1] = allRecording.get(i).getUsername();
            recordingData[i][2] = allRecording.get(i).getFid();
            recordingData[i][3] = allRecording.get(i).getLend();
            recordingData[i][4] = allRecording.get(i).getDeposit();
            recordingData[i][5] = allRecording.get(i).getBack();
            recordingData[i][6] = allRecording.get(i).getAmount();
        }
        return recordingData;
    }
    public static Object[][] getAllUserInfoData() {
    List<UserInfo> allUser = managerService.findAllUser();
    Object[][] userData = new Object[allUser.size()][3];
        for (int i = 0; i < allUser.size(); i++) {
            userData[i][0] = allUser.get(i).getUsername();
            userData[i][1] = allUser.get(i).getPassword();
            userData[i][2] = allUser.get(i).getPhonenum();
        }
        return userData;
    }
    public static Object[][] getVideoRecordingData() {
        List<VideoRecording> all = userService.findAllVideoRecording();
        Object[][] videoRecordingData = new Object[all.size()][3];
        for (int i = 0; i < all.size(); i++) {
            videoRecordingData[i][0] = all.get(i).getName();
            videoRecordingData[i][1] = all.get(i).getPrice();
            videoRecordingData[i][2] = all.get(i).getInventory();
        }
        return videoRecordingData;
    }
}
