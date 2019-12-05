package com.xu.vediorental.dao;




import com.xu.vediorental.doMain.table.FileInfo;
import com.xu.vediorental.doMain.table.RecordInfo;
import com.xu.vediorental.doMain.table.VedioInfo;
import com.xu.vediorental.doMain.view.AllFile;
import com.xu.vediorental.doMain.view.UserRentalHistory;
import com.xu.vediorental.doMain.view.VacantFile;
import com.xu.vediorental.doMain.view.VedioRecording;
import com.xu.vediorental.doMain.vo.BackInfo;
import com.xu.vediorental.doMain.vo.LendInfo;
import com.xu.vediorental.doMain.vo.NoReturnInfo;

import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 14:30 2019/11/26
 * @modified By
 */

public interface VedioDao {
    /**
     * 查找所有录像信息（含库存量和编号）
     * @return 录像信息列表
     */
    List<VedioInfo> findAllVedioInfo();

    /**
     * 查找所有录像信息（无编号）
     * @return 无编号录像信息列表
     */
    List<VedioRecording> findAllVedioRecording();

    /**
     * 查找所有空闲文件
     * @return 空闲文件列表
     */
    List<VacantFile> findAllVacantFile();

    /**
     * 根据用户名查询其未归还信息
     * @param username 用户名
     * @return 未归还信息
     */
    List<NoReturnInfo> findAllNoReturn(String username);

    /**
     * 查看所有文件（视图）
     * @return 文件列表
     */
    List<AllFile> findAllFile();

    /**
     * 租借录像后新增记录
     * @param lendInfo 租借信息
     * @return
     */
    void addRecording(LendInfo lendInfo);

    /**
     * 归还录像后跟新记录
     * @param backInfo 归还信息
     */
    void updateRecording(BackInfo backInfo);

    /**
     * 租借或归还后更新库存量
     * @param name 录像名
     * @param num 更新量
     */
    void changeInventoryByName(String name,long num);

    /**
     * 更改录像库存
     * @param id 录像id
     * @param num 更改库存量 1为库存加一，-1为库存减一
     */
    void changeInventoryById(long id,long num);

    /**
     * 租借或归还后更新文件状态
     * @param fid 文件号
     * @param num 更新量
     */
    void changeStatus(long fid,long num);

    /**
     * 增添录像
     * @param vedioInfo 录像信息
     * @return 增添成功数
     */
    int addVedio(VedioInfo vedioInfo);

    /**
     * 增添文件
     * @param fileInfo 文件信息
     * @return 增添成功数
     */
    int addFile(FileInfo fileInfo);

    /**
     * 查找所有录像信息
     * @return 录像信息列表
     */
    List<RecordInfo> findAllRecording();

    /**
     * 根据用户名查找其租赁记录
     * @param username 用户名
     * @return 该用户的租赁记录列表
     */
    List<UserRentalHistory> findAllRecordingByUsername(String username);

    /**
     * 根据录像id删除录像
     * @param id 录像id
     */
    void deleteVedioById(long id);

    /**
     * 根据文件id删除文件
     * @param id 文件id
     */
    void deleteFileById(long id);
}
