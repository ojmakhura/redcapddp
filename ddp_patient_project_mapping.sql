-- Change the project_id value on the next line to match the one for your DDP project.
set @project_id = XX;

-- Do NOT change anything below this line.
delete from redcap_ddp_mapping where project_id = @project_id;
delete from redcap_ddp_preview_fields where project_id = @project_id;
set @event_id = (select event_id from redcap_events_metadata m, redcap_events_arms a where a.arm_id = m.arm_id and a.project_id = @project_id order by a.arm_num, m.day_offset, m.descrip limit 1);
INSERT INTO redcap_ddp_preview_fields (project_id, field1, field2, field3, field4, field5) VALUES
(@project_id, 'idNumber', 'firstName', 'surname', 'dob', NULL);
INSERT INTO redcap_ddp_mapping (external_source_field_name, is_record_identifier, project_id, event_id, field_name, temporal_field, preselect) VALUES
('idNumber', 1, @project_id, @event_id, 'id_number', NULL, NULL),
('dob', NULL, @project_id, @event_id, 'dob', NULL, NULL),
('firstName', NULL, @project_id, @event_id, 'first_name', NULL, NULL),
('sex', NULL, @project_id, @event_id, 'sex', NULL, NULL),
('surname', NULL, @project_id, @event_id, 'surname', NULL, NULL),
('contactNumber', NULL, @project_id, @event_id, 'contact_number', NULL, NULL),
('batchNumber', NULL, @project_id, @event_id, 'batch_number', 'visit_date', NULL),
('dispatchedDateTime', NULL, @project_id, @event_id, 'dispatch_date_time', 'visit_date', NULL),
('sampleStatus', NULL, @project_id, @event_id, 'sample_status', 'visit_date', NULL),
('dispatcher', NULL, @project_id, @event_id, 'dispatcher', 'visit_date', NULL),
('dispatchLocation', NULL, @project_id, @event_id, 'dispatch_location', 'visit_date', NULL),
('collectionDateTime', NULL, @project_id, @event_id, 'collection_date_time', 'visit_date', NULL),
('latitude', NULL, @project_id, @event_id, 'latitude', 'visit_date', NULL),
('longitude', NULL, @project_id, @event_id, 'longitude', 'visit_date', NULL),
('locationDetails', NULL, @project_id, @event_id, 'location_details', 'visit_date', NULL);
