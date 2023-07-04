import os

ENTITIES_FOLDER_NAME = 'entities'
CONTROLLERS_FOLDER_NAME = 'controllers'
REPOSITORIES_FOLDER_NAME = 'repositories'
SERVICES_FOLDER_NAME = 'services'


def find_src():
    path_from_current_dir = '.'
    path = find_folder(path_from_current_dir, 'src')
    while path == None:
        path_from_current_dir += '.'
        path = find_folder(path_from_current_dir, 'src')
    return path

def find_folder(root_path, folder_name):
    for root, dirs, files in os.walk(root_path):
        if folder_name in dirs:
            return os.path.join(root, folder_name)
def find_path_to_entities(path_to_src):
    return find_folder(path_to_src, ENTITIES_FOLDER_NAME)

def find_path_to_repositories(path_to_src):
    return find_folder(path_to_src, REPOSITORIES_FOLDER_NAME)
def find_path_to_services(path_to_src):
    return find_folder(path_to_src, SERVICES_FOLDER_NAME)
def find_path_to_controllers(path_to_src):
    return find_folder(path_to_src, CONTROLLERS_FOLDER_NAME)