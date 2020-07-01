package com.bugly.system.rest;

import com.bugly.common.base.ApiResponse;
import com.bugly.system.dto.DealWithServerLogDto;
import com.bugly.system.service.ExceptionService;
import com.bugly.system.vo.BuglyDetailSearchVo;
import com.bugly.system.vo.BuglySearchVo;
import com.bugly.system.vo.CommonResult;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author no_f
 * rest
 * @create 2020-06-16 17:46
 */
@RestController
@RequestMapping("/exception")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ExceptionRestController {

    private final ExceptionService exceptionService;

    @PostMapping("/save")
    public CommonResult<Boolean> saveServiceLog(@RequestBody JSONObject jsonParam) {
        return exceptionService.saveServiceLog(jsonParam);
    }

    @GetMapping("/findAll")
    public ApiResponse findAll() {
        return exceptionService.findAll();
    }

    @PostMapping("/search")
    @ResponseBody
    public ApiResponse search(@RequestBody BuglySearchVo buglySearchVo) {
        return exceptionService.findByCondition(buglySearchVo);
    }

    @PostMapping("/deal_with")
    @ResponseBody
    public ApiResponse dealWith(@RequestBody DealWithServerLogDto dealWithServerLogDto) {
        return exceptionService.dealWith(dealWithServerLogDto);
    }

    @GetMapping("/detail_list")
    public ApiResponse getDetails(String exceptionTypeId) {
        return exceptionService.getDetailsAll(exceptionTypeId);
    }

    @PostMapping("/detail_search")
    @ResponseBody
    public ApiResponse detailSearch(@RequestBody BuglyDetailSearchVo buglyDetailSearchVo) {
        return exceptionService.getDetailsByCondition(buglyDetailSearchVo);
    }


}
