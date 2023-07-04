import string

import path_finder
from creator.entity import Entity, Types


def create_for_entity(path_to_src, entity):
    entities_path = path_finder.find_path_to_entities(path_to_src)
    repositories_path = path_finder.find_path_to_repositories(path_to_src)
    services_path = path_finder.find_path_to_services(path_to_src)
    controller_path = path_finder.find_path_to_controllers(path_to_src)

    create_entity(entity, entities_path)
    create_repository(entity, repositories_path)
    create_service(entity, services_path)
    create_controller(entity, controller_path)

def create_file_from_template(template_file, output_file, template_variables):
    with open(template_file, 'r') as file:
        template_content = file.read()
        template = string.Template(template_content)

        rendered_content = template.safe_substitute(template_variables)

    with open(output_file, 'w') as file:
        file.write(rendered_content)

def create_entity(entity, entity_path):
    template_variables = {
        'entity_name': entity.name,
        'full_package_name': 'com.zn.portfolio',
        'fields': entity.fields
    }
    template_variables_update(template_variables)
    create_file_from_template('creator/templates/entity_template.txt', f'{entity_path}/{entity.name}.java', template_variables)
def create_repository(entity, repository_path):
    repository_name = f'{entity.name}Repository'
    template_variables = {
        'entity_name': entity.name,
        'full_package_name': 'com.zn.portfolio',
        'repository_name':repository_name
    }
    create_file_from_template('creator/templates/repository_template.txt', f'{repository_path}/{repository_name}.java', template_variables)

def create_service(entity, service_path):
    entity_name = entity.name
    entity_name_plural =pluralize_word(entity.name)
    repository_name = f'{entity_name}Repository'
    service_name = f'{entity_name}Service'
    repository_name_lower = lower_first_letter(repository_name)
    service_name_lower = lower_first_letter(service_name)
    entity_name_lower = lower_first_letter(entity_name)
    template_variables = {
        'entity_name': entity_name,
        'full_package_name': 'com.zn.portfolio',
        'repository_name':repository_name,
        'repository_name_lower': repository_name_lower,
        'service_name': service_name,
        'service_name_lower': service_name_lower,
        'entity_name_lower': entity_name_lower,
        'entity_name_plural':entity_name_plural
    }
    create_file_from_template('creator/templates/service_template.txt', f'{service_path}/{service_name}.java', template_variables)
def stringify(str):
    return '"' +str + '"'
def create_controller(entity, controller_path):
    entity_name = entity.name
    entity_name_plural = pluralize_word(entity.name)
    repository_name = f'{entity_name}Repository'
    service_name = f'{entity_name}Service'
    controller_name = f'{entity_name}Controller'
    repository_name_lower = lower_first_letter(repository_name)
    service_name_lower = lower_first_letter(service_name)
    entity_name_lower = lower_first_letter(entity_name)
    API_URI = '/api/' + entity_name_plural.lower()
    API_ID_PATH_VAR = entity_name_lower+"Id"
    API_URI_SPECIFIC = API_URI +'/{' +API_ID_PATH_VAR+'}'

    template_variables = {
        'entity_name': entity_name,
        'controller_name':controller_name,
        'full_package_name': 'com.zn.portfolio',
        'repository_name': repository_name,
        'repository_name_lower': repository_name_lower,
        'service_name': service_name,
        'service_name_lower': service_name_lower,
        'entity_name_lower': entity_name_lower,
        'entity_name_plural': entity_name_plural,
        'API_URI': stringify(API_URI),
        'API_URI_SPECIFIC':stringify(API_URI_SPECIFIC),
        'API_ID_PATH_VAR':stringify(API_ID_PATH_VAR)
    }
    create_file_from_template('creator/templates/controller_template.txt', f'{controller_path}/{controller_name}.java',
                              template_variables)
def pluralize_word(word):
    if word.endswith(("s", "x", "z", "ch", "sh")):
        return word + "es"
    elif word.endswith("y") and len(word) > 1 and not word.endswith(("ay", "ey", "iy", "oy", "uy")):
        return word[:-1] + "ies"
    else:
        return word + "s"

def lower_first_letter(str):
    return str[0].lower() + str[1:]
def template_variables_update(template_variables):
    fields = template_variables['fields']
    fields_str = ""
    for field in fields:
        fields_str += field[0] + ' ' + field[1] + ';\n\t'
    template_variables['fields'] = fields_str