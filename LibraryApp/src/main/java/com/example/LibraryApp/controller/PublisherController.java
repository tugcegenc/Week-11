package com.example.LibraryApp.controller;

import com.example.LibraryApp.core.config.modelMapper.IModelMapperService;
import com.example.LibraryApp.core.result.Result;
import com.example.LibraryApp.core.result.ResultData;
import com.example.LibraryApp.core.utilies.ResultHelper;
import com.example.LibraryApp.dto.CursorResponse;
import com.example.LibraryApp.dto.request.publisher.PublisherSaveRequest;
import com.example.LibraryApp.dto.request.publisher.PublisherUpdateRequest;
import com.example.LibraryApp.dto.response.publisher.PublisherResponse;
import com.example.LibraryApp.entity.Publisher;
import com.example.LibraryApp.service.abstracts.IPublisherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/publishers")
public class PublisherController {

    @Autowired
    private IPublisherService publisherService;
    @Autowired
    private IModelMapperService modelMapper;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<PublisherResponse> save(@Valid @RequestBody PublisherSaveRequest publisherSaveRequest) {
        Publisher savePublisher = this.modelMapper.forRequest().map(publisherSaveRequest, Publisher.class);
        this.publisherService.save(savePublisher);
        return ResultHelper.created(this.modelMapper.forResponse().map(savePublisher, PublisherResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<PublisherResponse> get(@PathVariable("id") long id) {
        Publisher publisher = this.publisherService.get(id);
        PublisherResponse publisherResponse = this.modelMapper.forResponse().map(publisher, PublisherResponse.class);
        return ResultHelper.success(publisherResponse);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<PublisherResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        Page<Publisher> publisherPage = this.publisherService.cursor(page, pageSize);
        Page<PublisherResponse> publisherResponsePage = publisherPage
                .map(publisher -> this.modelMapper.forResponse().map(publisher, PublisherResponse.class));
        return ResultHelper.cursor(publisherResponsePage);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<PublisherResponse> update(@Valid @RequestBody PublisherUpdateRequest publisherUpdateRequest) {
        Publisher updatePublisher = this.modelMapper.forRequest().map(publisherUpdateRequest, Publisher.class);
        this.publisherService.update(updatePublisher);
        return ResultHelper.created(this.modelMapper.forResponse().map(updatePublisher, PublisherResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.publisherService.delete(id);
        return ResultHelper.successResult();
    }
}
