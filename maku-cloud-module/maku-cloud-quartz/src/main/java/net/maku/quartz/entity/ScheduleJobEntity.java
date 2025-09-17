package net.maku.quartz.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import net.maku.framework.mybatis.entity.BaseEntity;

import java.io.Serializable;

/**
 * 定时任务
 *
 * @author 阿沐 babamu@126.com
 */
@Data
@EqualsAndHashCode(callSuper=false)
@TableName("schedule_job")
public class ScheduleJobEntity extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	* 任务名称
	*/
	private String jobName;

	/**
	* 任务组名
	*/
	private String jobGroup;

	/**
	* bean名称
	*/
	private String beanName;

	/**
	 * 执行方法
	 */
	private String method;

	/**
	* 方法参数
	*/
	private String params;

	/**
	* cron表达式
	*/
	private String cronExpression;

	/**
	* 状态 
	*/
	private Integer status;

	/**
	* 是否并发  0：禁止  1：允许
	*/
	private Integer concurrent;

	/**
	* 备注
	*/
	private String remark;

}