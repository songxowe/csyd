package com.csyd.core.service;

import com.csyd.core.dao.OrganMapper;
import com.csyd.core.util.Pager;
import com.csyd.pojo.Organ;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.beans.IntrospectionException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class OrganService {
    @Resource(name = "organMapper")
    private OrganMapper organMapper;

    public int add(Organ organ) {
        return organMapper.add(organ);
    }

    public int update(Organ organ) {
        return organMapper.update(organ);
    }

    public int delete(Integer organId) {
        return organMapper.delete(organId);
    }

    public List<Organ> find() {
        return organMapper.find();

    }

    public Organ findById(Integer organId) {
        return organMapper.findById(organId);
    }

    public Pager<Organ> findPager(String organName,
                                  String sort,
                                  String order,
                                  Integer page,
                                  Integer rows) {
        Pager<Organ> pager = new Pager<Organ>();
        pager.setRows(organMapper.findPager(organName, sort, order, page, rows));
        pager.setTotal(organMapper.getTotal(organName));
        return pager;
    }


}
