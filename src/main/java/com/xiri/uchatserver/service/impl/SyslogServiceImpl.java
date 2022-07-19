package com.xiri.uchatserver.service.impl;

import com.xiri.uchatserver.model.entity.Syslog;
import com.xiri.uchatserver.mapper.SyslogMapper;
import com.xiri.uchatserver.service.ISyslogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gjy
 * @since 2022-07-19
 */
@Service
public class SyslogServiceImpl extends ServiceImpl<SyslogMapper, Syslog> implements ISyslogService {

}
