package com.tensquare.recruit.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import util.IdWorker;

import com.tensquare.recruit.dao.RecruitDao;
import com.tensquare.recruit.pojo.Recruit;

/**
 * 职位服务层
 * @author TianCi.Xiong
 * @since 2020/10/14 14:26
 */
@Service
public class RecruitService {

    @Autowired
    private RecruitDao recruitDao;

    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部列表
     * @return
     */
    public List<Recruit> findAll() {
        return recruitDao.findAll();
    }


    /**
     * 条件查询+分页
     * @param whereMap
     * @param page
     * @param size
     * @return
     */
    public Page<Recruit> findSearch(Map whereMap, int page, int size) {
        Specification<Recruit> specification = createSpecification(whereMap);
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        return recruitDao.findAll(specification, pageRequest);
    }


    /**
     * 条件查询
     * @param whereMap
     * @return
     */
    public List<Recruit> findSearch(Map whereMap) {
        Specification<Recruit> specification = createSpecification(whereMap);
        return recruitDao.findAll(specification);
    }

    /**
     * 根据ID查询实体
     * @param id
     * @return
     */
    public Recruit findById(String id) {
        return recruitDao.findById(id).get();
    }

    /**
     * 增加
     * @param recruit
     */
    public void add(Recruit recruit) {
        // 雪花分布式ID生成器
        recruit.setId(idWorker.nextId() + "");
        recruitDao.save(recruit);
    }

    /**
     * 修改
     * @param recruit
     */
    public void update(Recruit recruit) {
        recruitDao.save(recruit);
    }

    /**
     * 删除
     * @param id
     */
    public void deleteById(String id) {
        recruitDao.deleteById(id);
    }

    /**
     * 动态条件构建
     * @param searchMap
     * @return
     */
    private Specification<Recruit> createSpecification(Map searchMap) {

        return new Specification<Recruit>() {
            @Override
            public Predicate toPredicate(Root<Recruit> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<Predicate>();
                // ID
                if (searchMap.get("id") != null && !"".equals(searchMap.get("id"))) {
                    predicateList.add(cb.equal(root.get("id").as(String.class), (String) searchMap.get("id")));
                }
                // 职位名称
                if (searchMap.get("jobname") != null && !"".equals(searchMap.get("jobname"))) {
                    predicateList.add(cb.like(root.get("jobname").as(String.class), "%" + (String) searchMap.get("jobname") + "%"));
                }
                // 学历要求
                if (searchMap.get("education") != null && !"".equals(searchMap.get("education"))) {
                    predicateList.add(cb.equal(root.get("education").as(String.class), (String) searchMap.get("education")));
                }
                // 任职方式
                if (searchMap.get("type") != null && !"".equals(searchMap.get("type"))) {
                    predicateList.add(cb.equal(root.get("type").as(String.class), (String) searchMap.get("type")));
                }
                // 办公地址
                if (searchMap.get("address") != null && !"".equals(searchMap.get("address"))) {
                    predicateList.add(cb.like(root.get("address").as(String.class), "%" + (String) searchMap.get("address") + "%"));
                }
                // 企业ID
                if (searchMap.get("eid") != null && !"".equals(searchMap.get("eid"))) {
                    predicateList.add(cb.equal(root.get("eid").as(String.class), (String) searchMap.get("eid")));
                }
                // 状态
                if (searchMap.get("state") != null && !"".equals(searchMap.get("state"))) {
                    predicateList.add(cb.equal(root.get("state").as(String.class), (String) searchMap.get("state")));
                }

                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
    }

    /**
     * 根据状态查询
     * @param state
     * @return
     */
    public List<Recruit> findTop4ByStateOrderByCreatetimeDesc(String state) {
        return recruitDao.findTop4ByStateOrderByCreatetimeDesc(state);
    }

    /**
     * 最新职位列表<br/>
     * 查询状态不为0并以创建日期降序排序，查询前12条记录
     * @return
     */
    public List<Recruit> newlist() {
        return recruitDao.findTop12ByStateNotOrderByCreatetimeDesc("0");
    }
}
